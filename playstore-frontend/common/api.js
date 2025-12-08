// common/api.js
import { getToken } from './auth.js';

const BASE = 'http://localhost:8000'; // API Gateway

export async function post(path, body, useAuth = false) {
    const headers = { 'Content-Type': 'application/json' };
    if (useAuth) headers['Authorization'] = 'Bearer ' + getToken();
    const res = await fetch(BASE + path, {
        method: 'POST',
        headers,
        body: JSON.stringify(body)
    });
    return res;
}

export async function get(path, useAuth = false) {
    const headers = {};
    if (useAuth) headers['Authorization'] = 'Bearer ' + getToken();
    const res = await fetch(BASE + path, { headers });
    return res;
}
