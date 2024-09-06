document.getElementById('registration-form').addEventListener('submit', function(event) {
    event.preventDefault(); 

    const popup = document.getElementById('popup');
    popup.style.display = 'block';

    setTimeout(function() {
        popup.style.display = 'none';
    }, 3000);

    sendPostRequest();
});

function sendPostRequest() {
    const url = '/abcresturant/customer'; 

    const formData = new URLSearchParams();
	formData.append('customerid', document.getElementById('customerid').value);
    formData.append('name', document.getElementById('name').value);
    formData.append('email', document.getElementById('email').value);
	formData.append('phone', document.getElementById('phone').value);
	formData.append('address', document.getElementById('address').value);
    formData.append('password', document.getElementById('password').value);

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





