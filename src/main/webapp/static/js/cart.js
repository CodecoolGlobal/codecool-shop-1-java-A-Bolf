console.log("adsd")
document.addEventListener("DOMContentLoaded", function () {
    let totalPrice = document.querySelector(".total");
    let deleteButtons = document.querySelectorAll(".delete-btn");
    let cartButtons = document.querySelectorAll(".add-to-cart");
    let itemcount = document.querySelector("#item-count");
    let headerItemCount = document.querySelector("#header-item-count");
    let newtotal;
    console.log(cartButtons);
    for (let i = 0; i < cartButtons.length; i++) {
        cartButtons[i].addEventListener('click', async function () {
            let productID = cartButtons[i].dataset['product_id'];
            await apiGET(`/api/cart/add?id=${productID}`);
            newtotal = await (await apiGET(`/api/cart/total`)).json();
            headerItemCount.textContent = await newtotal.count;
        });
    }
    for (let i = 0; i < deleteButtons.length; i++) {
        deleteButtons[i].addEventListener('click', async function () {
            let productID = deleteButtons[i].dataset['product_id'];
            await apiGET(`/api/cart/remove?id=${productID}`);
            deleteButtons[i].parentElement.parentElement.remove();
            newtotal = await (await apiGET(`/api/cart/total`)).json();
            totalPrice.textContent = "Total: " + await newtotal.total + "$";
            itemcount.textContent = await newtotal.count + " Items in cart:";
            headerItemCount.textContent = await newtotal.count;
        });
    }
});

async function apiGET(url) {
    return await fetch(url, {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    });
}
