const form = document.getElementById('signupForm');
const message = document.getElementById('message');

form.addEventListener('submit', async (e) => {
    e.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const gender = document.getElementById('gender').value;
    const dob = document.getElementById('dob').value;
    const phoneNumber = document.getElementById('phoneNo').value;
    const aadhaarNumber = document.getElementById('aadhaar').value;

    message.textContent = '';
    message.style.color = 'black';

    try {
        const response = await fetch('http://localhost:8080/auth/signup', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email,
                password,
                gender,
                dob,
                phoneNo: phoneNumber,
                aadhaar: aadhaarNumber
            })
        });

        const data = await response.json();

        if (!response.ok) {
            message.textContent = Object.values(data)[0] || "Signup failed";
            message.style.color = 'red';
            return;
        }

        message.textContent = 'Signup successful!';
        message.style.color = 'green';

        form.reset();

    } catch (error) {
        console.error('Fetch error:', error);
        message.textContent = 'Server not reachable or CORS blocked';
        message.style.color = 'red';
    }
});