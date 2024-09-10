document.addEventListener('DOMContentLoaded', function () {
    const offersContainer = document.getElementById('offers-container');
    const loadOffersButton = document.getElementById('load-offers');

    const offers = [
        { id: 1, title: "50% Off on All Pizzas", description: "Get a massive 50% discount on all pizzas this weekend!" },
        { id: 2, title: "Buy One Get One Free", description: "Order any main course and get another absolutely free!" },
        { id: 3, title: "20% Off for Students", description: "Students get a 20% discount on all menu items. Show your ID!" },
        { id: 4, title: "Happy Hours", description: "Enjoy happy hours with discounted drinks from 5 PM to 7 PM every day!" }
    ];

    let offersLoaded = 0;

    function loadMoreOffers() {
        const offersToLoad = 2; 
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

    loadMoreOffers();

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

    const menuForm = document.getElementById('menu-form');
    const popup = document.getElementById('popup'); 

    menuForm.addEventListener('submit', function (event) {
        event.preventDefault(); 
        popup.style.display = 'block';

        setTimeout(function () {
            popup.style.display = 'none';
        }, 3000);

        sendPostRequest();
    });

    function sendPostRequest() {
        const url = '/abcrestaurant/menu'; 

        const formData = new URLSearchParams();
        formData.append('id', document.getElementById('menu-id').value);
        formData.append('name', document.getElementById('menu-name').value);
        formData.append('description', document.getElementById('menu-description').value);
        formData.append('price', document.getElementById('menu-price').value);
        formData.append('category', document.getElementById('menu-category').value);

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
