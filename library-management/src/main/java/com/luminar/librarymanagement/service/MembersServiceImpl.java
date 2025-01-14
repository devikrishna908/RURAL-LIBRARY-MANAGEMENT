package com.luminar.librarymanagement.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.luminar.librarymanagement.entity.Members;
import com.luminar.librarymanagement.repository.MembersRepository;

@Service
public class MembersServiceImpl implements MembersService {

	@Autowired
	private MembersRepository membersRepository;

	@Override
	public List<Members> getAllMembers() {
		return membersRepository.findAll();
	}

	@Override
	public void saveMember(Members member) {
		
		member.setName(member.getName().toUpperCase());
		member.setAddress(member.getAddress().toUpperCase());
		member.setEmail(member.getEmail().toUpperCase());
		LocalDate currentDate = LocalDate.now();
        member.setMembership_taken_on(currentDate);
        member.setMembership_due_on(currentDate.plusDays(90));
        member.setStatus("ACTIVE");
        membersRepository.save(member);		
	}

	@Override
	public void deleteMemberById(Integer memberId) {
		membersRepository.deleteById(memberId);
	}

	@Override
	public Members getMemberById(Integer id) {
		return membersRepository.findById(id).orElse(null);
	}

	@Override
	public void updateMember(Members member) {
		member.setName(member.getName().toUpperCase());
		member.setAddress(member.getAddress().toUpperCase());
		member.setEmail(member.getEmail().toUpperCase());
		membersRepository.save(member);
	}
	
    @Override
    public void updateMemberDueDates() {
        LocalDate currentDate = LocalDate.now();
        List<Members> members = membersRepository.findAll();

        for (Members member : members) {
            if (member.getMembership_due_on().isBefore(currentDate)) {
                member.setStatus("INACTIVE");
            }
        }

        membersRepository.saveAll(members);
    }

    @Scheduled(initialDelay = 0, fixedRate = 86400000) 
    public void scheduledUpdateMemberDueDates() {
        updateMemberDueDates();
    }

	@Override
	public long getTotalMembers() {
		return membersRepository.count();
	}

	
}
