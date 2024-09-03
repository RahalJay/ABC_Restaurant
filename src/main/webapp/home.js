// JavaScript for dynamic offer loading and viewing offers
document.addEventListener('DOMContentLoaded', function () {
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
        const offersToLoad = 1; // Number of offers to load at a time
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

    // Add click event to each offer item to show modal
    offersContainer.addEventListener('click', function (event) {
        if (event.target.closest('.offer-item')) {
            const offerTitle = event.target.closest('.offer-item').querySelector('h3').innerText;
            const offerDescription = event.target.closest('.offer-item').querySelector('p').innerText;
            showOfferModal(offerTitle, offerDescription);
        }
    });

    function showOfferModal(title, description) {
        const modalHTML = `
            <div class="modal">
                <div class="modal-content">
                    <span class="close-button">&times;</span>
                    <h2>${title}</h2>
                    <p>${description}</p>
                </div>
            </div>
        `;
        document.body.insertAdjacentHTML('beforeend', modalHTML);

        const modal = document.querySelector('.modal');
        const closeButton = modal.querySelector('.close-button');

        closeButton.addEventListener('click', () => {
            modal.remove();
        });

        modal.addEventListener('click', (e) => {
            if (e.target === modal) {
                modal.remove();
            }
        });
    }
});
