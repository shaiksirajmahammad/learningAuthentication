async function loadWelcome() {

    const message = document.getElementById("message");

    const token = localStorage.getItem("jwt");

    if (!token) {
        message.textContent = "Please login first";
        message.style.color = "red";
        return;
    }

    try {

        const response = await fetch("http://localhost:8080/home/welcome", {
            method: "GET",
            headers: {
                "Authorization": "Bearer " + token
            }
        });

        const text = await response.text();

        if (!response.ok) {
            message.textContent = "Access denied";
            message.style.color = "red";
            return;
        }

        message.textContent = text;
        message.style.color = "green";

    } catch (error) {

        console.error(error);
        message.textContent = "Server error";

    }
}