document.addEventListener('DOMContentLoaded', function () {
    const loginForm = document.getElementById("login-form");
    const cancelButton = document.getElementById("cancel-btn");
    const popup = document.getElementById('popup'); 


    loginForm.addEventListener("submit", function (event) {
        event.preventDefault(); 

        popup.style.display = 'block';

        setTimeout(function () {
            popup.style.display = 'none';
        }, 3000);

        sendPostRequest();
    });

    cancelButton.addEventListener("click", function () {s
        loginForm.reset();
    });

    function sendPostRequest() {
        const url = '/abcrestaurant/login'; 

        const formData = new URLSearchParams();
        formData.append('username', document.getElementById('username').value);
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
            window.location.href = "home.html";
        })
        .catch(error => {
            console.error('Error:', error);
        });
    }
});
