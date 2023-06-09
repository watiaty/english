import React, {useState, useEffect} from 'react';
import axios from 'axios';
import {Link} from 'react-router-dom';
import {Button} from "@mui/material";
import CssBaseline from "@mui/material/CssBaseline";
// import jwtDecode from 'jwt-decode';

export default function Test() {
    const [data, setData] = useState(null);
    const token = localStorage.getItem('access_token');
    const [countLearnedWords, setCountLearnedWords] = useState([]);
    const [countLearningWords, setCountLearningWords] = useState([]);
    // const decodedToken = jwtDecode(token);
    // const username = decodedToken.sub;

    useEffect(() => {
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
                // setClients(body);
            } catch (error) {
                console.error('Failed to fetch clients:', error);
            }
        };
        fetchData();
    }, []);

    useEffect(() => {
        const countLearningWords = async () => {
            try {
                const response = await fetch('api/v1/wordlist/count-learning-words', {
                    headers: {
                        Authorization: `Bearer ${token}`,
                    },
                });
                const body = await response.json();
                setCountLearningWords(body);
            } catch (error) {
                console.error('Failed to fetch clients:', error);
            }
        };
        countLearningWords();
    }, []);

    useEffect(() => {
        const countLearnedWords = async () => {
            try {
                const response = await fetch('api/v1/wordlist/count-learned-words', {
                    headers: {
                        Authorization: `Bearer ${token}`,
                    },
                });
                const body = await response.json();
                setCountLearnedWords(body);
            } catch (error) {
                console.error('Failed to fetch clients:', error);
            }
        };
        countLearnedWords();
    }, []);

    return (
        <React.Fragment>
            <CssBaseline/>
            <div>
                {data ? (
                    <div>
                        <Button variant="outlined" color="primary" onClick={logout}>
                            Logout
                        </Button>
                        <div>Изучено слов: {countLearnedWords}</div>
                        <div>Слов на изучении: {countLearningWords}</div>
                    </div>
                ) : (
                    <div>

                        <Button component={Link} to="/sign-in" variant="contained">
                            Login
                        </Button>
                        <Button component={Link} to="/sign-up" variant="contained" color="primary">
                            Register
                        </Button>
                    </div>
                )}
                {/*<h2>Not protected data</h2>*/}
                {/*{clients.map((client) => (*/}
                {/*    <div key={client.id}>{client.word}</div>*/}
                {/*))}*/}
                <h2>Words</h2>
                <Button component={Link} to="/new-words" variant="contained">
                    Learn new words
                </Button>
                <Button component={Link} to="/practice" variant="contained">
                    Practice
                </Button>
                <Button component={Link} to="/my-words" variant="contained">
                    My words
                </Button>
            </div>
        </React.Fragment>
    );
}
