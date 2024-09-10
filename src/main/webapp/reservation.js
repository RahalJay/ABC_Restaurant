document.addEventListener('DOMContentLoaded', function () {
    const reservationForm = document.getElementById('reservation');
    const popup = document.getElementById('popup');
    const closePopupButton = document.getElementById('close-popup');
    const cancelButton = document.getElementById('cancel');
    const reservationIDField = document.getElementById('id');

    function generateReservationID() {
        return Math.floor(100 + Math.random() * 900).toString(); 
    }

    reservationIDField.value = generateReservationID();
    reservationIDField.readOnly = true; 

    reservationForm.addEventListener('submit', function (event) {
        event.preventDefault(); 

        popup.style.display = 'block';

        setTimeout(function () {
            popup.style.display = 'none';
        }, 3000);

        sendPostRequest();
    });

    closePopupButton.addEventListener('click', function () {
        popup.style.display = 'none'; 
        reservationForm.reset(); 
        reservationIDField.value = generateReservationID(); 
        reservationIDField.readOnly = true; 
    });

    cancelButton.addEventListener('click', function () {
        window.location.href = 'home.html'; 
    });

    function sendPostRequest() {
        const url = '/abcresturant/reservation'; 

        const formData = new URLSearchParams();
        formData.append('id', reservationIDField.value);
        formData.append('customerId', document.getElementById('customer-id').value);
        formData.append('reservationDate', document.getElementById('reservation-date').value);
        formData.append('reservationTime', document.getElementById('reservation-time').value);
        formData.append('reservationType', document.getElementById('reservation-type').value);

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
});
