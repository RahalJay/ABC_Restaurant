document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('query-form');

    form.addEventListener('submit', function (event) {
        event.preventDefault(); 
        const popup = document.getElementById('popup');
        popup.style.display = 'block';

        setTimeout(function () {
            popup.style.display = 'none';
        }, 3000);

        sendPostRequest();
    });

    function sendPostRequest() {
        const url = '/abcresturant/query'; 

        const formData = new URLSearchParams();
        formData.append('queryId', document.getElementById('query-id').value);
        formData.append('customerId', document.getElementById('customer-id').value);
        formData.append('queryType', document.getElementById('query-type').value);
        formData.append('queryDescription', document.getElementById('query-description').value);
        formData.append('status', 'Pending'); 
        formData.append('response', ''); 

        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded', 
            },
            body: formData.toString(), 
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); 
        })
        .then(result => {
            console.log('Success:', result);
        })
        .catch(error => {
            console.error('Error:', error);
        });
    }

    function handleFormSubmission() {

        const successMessage = document.createElement('div');
        successMessage.classList.add('success-message');
        successMessage.innerHTML = `
            <h3>Your Query was added successfully!</h3>
            <p>Thank you for reaching out. We will get back to you shortly.</p>
        `;

        document.body.appendChild(successMessage);

        setTimeout(() => {
            successMessage.remove();
        }, 5000);

        form.reset();
    }
});
