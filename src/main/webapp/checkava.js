document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('availability-form');
    const resultDisplay = document.getElementById('result-display');
    const popup = document.getElementById('popup'); 
    const resetButton = form.querySelector('button[type="reset"]');


    form.addEventListener('submit', function(event) {
        event.preventDefault(); 
        
        popup.style.display = 'block';

        setTimeout(function() {
            popup.style.display = 'none';
        }, 3000);

        checkAvailability();
    });

    resetButton.addEventListener('click', function() {
        resultDisplay.style.display = 'none'; 
    });

    function checkAvailability() {
        const serviceType = document.getElementById('service-type').value;
        const date = document.getElementById('reservation-date').value;
        const timeSlot = document.getElementById('reservation-time').value;
        const availableSlots = document.getElementById('available-slots').value;

        const url = '/abcrestaurant/availability'; 
        const formData = new URLSearchParams();
        formData.append('serviceType', serviceType);
        formData.append('date', date);
        formData.append('timeSlot', timeSlot);
        formData.append('availableSlots', availableSlots);

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
            displayResult(result);
        })
        .catch(error => {
            console.error('Error:', error);
        });
    }

    function displayResult(result) {
        let resultMessage = `Service Type: ${result.serviceType}\nDate: ${result.date}\nTime Slot: ${result.timeSlot}\nAvailable Slots: ${result.availableSlots}`;
        
        resultDisplay.textContent = resultMessage;
        resultDisplay.style.display = 'block';
    }
});
