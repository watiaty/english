import React, { useState, useEffect } from 'react';
import Login from "./components/LoginPage";
import Register from "./components/RegisterPage";
import Test from "./components/TestPage";

const App = () => {

    const [clients, setClients] = useState([]);

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
        <div className="App">
            <header className="App-header">
                <div className="App-intro">
                    <h2>Clients</h2>
                    {clients.map(client =>
                        <div key={client.id}>
                            {client.word}
                        </div>
                    )}
                </div>
                <Test/>
                <Login/>
                <Register/>
                {/*<Routes/>*/}
            </header>
        </div>
    );
};

export default App;