const API_URL = 'http://localhost:8080/api';

// Utilities
function setAuth(user) {
    localStorage.setItem('user', JSON.stringify(user));
}

function getAuth() {
    const user = localStorage.getItem('user');
    return user ? JSON.parse(user) : null;
}

function logout() {
    localStorage.removeItem('user');
    window.location.href = 'login.html';
}

function checkAuth() {
    const user = getAuth();
    if (!user) {
        window.location.href = 'login.html';
    }
    return user;
}

function updateNav() {
    const user = getAuth();
    const nav = document.getElementById('nav-links');
    if(nav) {
        if(user) {
            nav.innerHTML = `
                <span style="color:white; margin-right: 15px;">こんにちは、${user.username}さん</span>
                <a href="index.html">メニュー</a>
                <a href="orders.html">注文履歴</a>
                <a href="#" onclick="logout()">ログアウト</a>
            `;
        } else {
            nav.innerHTML = `
                <a href="login.html">ログイン</a>
                <a href="register.html">登録</a>
            `;
        }
    }
}

document.addEventListener('DOMContentLoaded', updateNav);
