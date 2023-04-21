import React, {useState} from 'react'
import axios from 'axios';
import validator from 'validator';

export default function Login() {
    const [login, setLogin] = useState(() => {
        return {
            email: "",
            password: "",
        }
    })

    const changeInputLogin = event => {
        event.persist()
        setLogin(prev => {
            return {
                ...prev,
                [event.target.name]: event.target.value,
            }
        })
    }

    const submitCheckin = event => {
        event.preventDefault();
        if (!validator.isEmail(login.email)) {
            alert("You did not enter email")
        } else {
            axios.post("http://localhost:8080/api/v1/auth/authenticate", {
                email: login.email,
                password: login.password,
            }).then(res => {
                const {data} = res;
                if (data.access_token && data.refresh_token) {
                    localStorage.setItem('access_token', data.access_token);
                    localStorage.setItem('refresh_token', data.refresh_token);
                    window.location.href = "http://localhost:3000" + "/auth"
                } else {
                    alert("Failed. Try again")
                }
            }).catch(error => {
                if (error.response && error.response.status === 403) {
                    alert("There is already a user with this email")
                }
            })
        }
    }

    return (
        <div className="form">
            <h2>Login user:</h2>
            <form onSubmit={submitCheckin}>
                <p>Email: <input
                    type="email"
                    id="email"
                    name="email"
                    value={login.email}
                    onChange={changeInputLogin}
                /></p>
                <p>Password: <input
                    type="password"
                    id="password"
                    name="password"
                    value={login.password}
                    onChange={changeInputLogin}
                /></p>
                <input type="submit"/>
            </form>
        </div>
    )
}