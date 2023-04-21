import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import {Button} from "@mui/material";

export default function Test() {
    const [data, setData] = useState(null);

    useEffect(() => {
        const token = localStorage.getItem('access_token');
        axios
            .get('http://localhost:8080/api/v1/demo-controller', {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            })
            .then((response) => {
                setData(response.data);
            })
            .catch((error) => {
                console.log(error);
            });
    }, []);

    const [clients, setClients] = useState([]);

    const logout = async () => {
        try {
            await axios.post('http://localhost:8080/api/v1/auth/logout');
            localStorage.removeItem('access_token');
            window.location.href = 'http://localhost:3000';
        } catch (error) {
            console.log(error);
        }
    };

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch('api/v1/words');
                const body = await response.json();
                setClients(body);
            } catch (error) {
                console.error('Failed to fetch clients:', error);
            }
        };
        fetchData();
    }, []);

    return (
        <div>
            {data ? (
                <div>
                    <Button variant="contained" color="primary" onClick={logout}>
                        Logout
                    </Button>
                </div>
            ) : (
                <div>
                    <Button component={Link} to="/login" variant="contained" color="primary">
                        Login
                    </Button>
                    <Button component={Link} to="/register" variant="contained" color="primary">
                        Register
                    </Button>
                </div>
            )}
            <h2>Not protected data</h2>
            {clients.map((client) => (
                <div key={client.id}>{client.word}</div>
            ))}
            {data ? (
                <div>
                    <h2>Protected Data</h2>
                    <p>{data}</p>
                </div>
            ) : (
                <p>Loading...</p>
            )}
        </div>
    );
}
