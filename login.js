const form = document.getElementById("loginForm");
const message = document.getElementById("message");

form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value.trim();

    message.textContent = "";
    message.style.color = "black";

    try {

        const response = await fetch("http://localhost:8080/auth/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                email,
                password
            })
        });

        const data = await response.json();

        if (!response.ok) {
            message.textContent = "Login failed";
            message.style.color = "red";
            return;
        }

        // store JWT token
        localStorage.setItem("jwt", data.jwt);

        message.textContent = "Login successful!";
        message.style.color = "green";

        console.log("JWT:", data.jwt);
        setTimeout(() => {
            window.location.href = "welcome.html";
        }, 1000);

        // optional redirect
        // window.location.href = "home.html";

    } catch (error) {

        console.error("Error:", error);
        message.textContent = "Server not reachable";
        message.style.color = "red";

    }
});