// common/auth.js

const TOKEN_KEY = 'playstore_token';
const ROLE_KEY = 'playstore_role';
const USERNAME_KEY = 'playstore_user';

export function saveAuth(token, role, username) {
    localStorage.setItem(TOKEN_KEY, token);
    localStorage.setItem(ROLE_KEY, role);
    if (username) localStorage.setItem(USERNAME_KEY, username);
}

export function getToken() {
    return localStorage.getItem(TOKEN_KEY);
}

export function getRole() {
    return localStorage.getItem(ROLE_KEY);
}

export function getUsername() {
    return localStorage.getItem(USERNAME_KEY);
}

export function clearAuth() {
    localStorage.removeItem(TOKEN_KEY);
    localStorage.removeItem(ROLE_KEY);
    localStorage.removeItem(USERNAME_KEY);
}

export function authHeader() {
    const t = getToken();
    return t ? { 'Authorization': 'Bearer ' + t } : {};
}

export function isLoggedIn() {
    return !!getToken();
}

// Basic role check
export function requireRole(role) {
    if (!isLoggedIn() || getRole() !== role) {
        // redirect to that role's login page
        if (role === 'OWNER') window.location.href = '/owner/owner-login.html';
        else window.location.href = '/user/user-login.html';
    }
}
