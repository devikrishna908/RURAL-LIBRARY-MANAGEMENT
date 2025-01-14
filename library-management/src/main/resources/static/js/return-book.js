
function viewAction() {
    var memRegno = document.getElementById('mem_regno').value;
    if (memRegno) {
        fetch(`/get-issued-books?mem_regno=${memRegno}`)
            .then(response => response.json())
            .then(data => {
                displayIssuedBooks(data);
            })
            .catch(error => {
                console.error('Error fetching issued books:', error);
            });
    } else {
        alert('Please enter a member registration number.');
    }
}


function displayIssuedBooks(books) {
    var container = document.getElementById('issued-books-container');
    container.innerHTML = ''; // Clear previous contents

    if (books.length === 0) {
        container.innerHTML = '<p>NO BOOKS ISSUED TO THIS MEMBER</p>';
        return;
    }

    var table = document.createElement('table');
    table.classList.add('issued-books-table');

    var thead = document.createElement('thead');
    var headerRow = document.createElement('tr');
    var headers = ['ISSUE ID', 'BOOK TITLE', 'ISSUE DATE', 'DUE DATE', 'ACTIONS'];
    headers.forEach(header => {
        var th = document.createElement('th');
        th.textContent = header;
        headerRow.appendChild(th);
    });
    thead.appendChild(headerRow);
    table.appendChild(thead);

    var tbody = document.createElement('tbody');
    books.forEach(book => {
        var row = document.createElement('tr');
        var cells = [
            book.issueId, book.bookTitle, book.issueDate, book.dueDate
        ];
        cells.forEach(cell => {
            var td = document.createElement('td');
            td.textContent = cell;
            row.appendChild(td);
        });

        var actionTd = document.createElement('td');
        var returnLink = document.createElement('a');
        returnLink.href = `/return-book?issueId=${book.issueId}`;
        returnLink.textContent = 'RETURN';
        actionTd.appendChild(returnLink);
        row.appendChild(actionTd);

        tbody.appendChild(row);
    });
    table.appendChild(tbody);

    container.appendChild(table);
}
