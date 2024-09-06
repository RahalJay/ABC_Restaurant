document.addEventListener('DOMContentLoaded', function () {
    // JavaScript for dynamic offer loading
    const offersContainer = document.getElementById('offers-container');
    const loadOffersButton = document.getElementById('load-offers');

    // Dummy data for offers
    const offers = [
        { id: 1, title: "50% Off on All Pizzas", description: "Get a massive 50% discount on all pizzas this weekend!" },
        { id: 2, title: "Buy One Get One Free", description: "Order any main course and get another absolutely free!" },
        { id: 3, title: "20% Off for Students", description: "Students get a 20% discount on all menu items. Show your ID!" },
        { id: 4, title: "Happy Hours", description: "Enjoy happy hours with discounted drinks from 5 PM to 7 PM every day!" }
    ];

    let offersLoaded = 0;

    function loadMoreOffers() {
        const offersToLoad = 2; // Number of offers to load at a time
        for (let i = offersLoaded; i < offersLoaded + offersToLoad && i < offers.length; i++) {
            const offer = offers[i];
            const offerElement = document.createElement('div');
            offerElement.classList.add('offer-item');
            offerElement.innerHTML = `
                <h3>${offer.title}</h3>
                <p>${offer.description}</p>
            `;
            offersContainer.appendChild(offerElement);
        }
        offersLoaded += offersToLoad;

        if (offersLoaded >= offers.length) {
            loadOffersButton.style.display = 'none';
        }
    }

    loadOffersButton.addEventListener('click', loadMoreOffers);

    // Initial load of offers
    loadMoreOffers();

    // JavaScript for toggling menu categories
    const menuCategories = document.querySelectorAll('.menu-category h2');

    menuCategories.forEach(category => {
        category.addEventListener('click', function () {
            const items = this.nextElementSibling;
            if (items.style.display === 'none' || items.style.display === '') {
                items.style.display = 'block';
            } else {
                items.style.display = 'none';
            }
        });
    });

    // Additional JavaScript for menu item form submission
    const menuForm = document.getElementById('menu-form');
    const popup = document.getElementById('popup'); // Popup element

    menuForm.addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent the form from submitting the usual way

        // Display popup message
        popup.style.display = 'block';

        // Hide the popup after 3 seconds
        setTimeout(function () {
            popup.style.display = 'none';
        }, 3000);

        // Send the form data to the servlet
        sendPostRequest();
    });

    function sendPostRequest() {
        const url = '/abcrestaurant/menu'; // Ensure this URL matches your servlet's mapping

        // Collect form data
        const formData = new URLSearchParams();
        formData.append('id', document.getElementById('menu-id').value);
        formData.append('name', document.getElementById('menu-name').value);
        formData.append('description', document.getElementById('menu-description').value);
        formData.append('price', document.getElementById('menu-price').value);
        formData.append('category', document.getElementById('menu-category').value);

        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded', // Sending data as form URL encoded
            },
            body: formData.toString(), // Convert form data to URL-encoded string
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); // Assuming the servlet returns a JSON response
        })
        .then(result => {
            console.log('Success:', result);
        })
        .catch(error => {
            console.error('Error:', error);
        });
    }
});
