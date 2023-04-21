import React, {useState} from "react";
import validator from "validator";
import axios from "axios";

export default function Register() {
    const [register, setRegister] = useState(() => {
        return {
            firstname: "",
            lastname: "",
            email: "",
            password: "",
            password2: "",
        }
    })

    const changeInputRegister = event => {
        event.persist()
        setRegister(prev => {
            return {
                ...prev,
                [event.target.name]: event.target.value,
            }
        })
    }

    const submitCheckin = event => {
        event.preventDefault();
        if (!validator.isEmail(register.email)) {
            alert("You did not enter email")
        } else if (register.password !== register.password2) {
            alert("Repeated password incorrectly")
        } else if (!validator.isStrongPassword(register.password, {minSymbols: 0})) {
            alert("Password must consist of one lowercase, uppercase letter and number, at least 8 characters")
        } else {
            axios.post("http://localhost:8080/api/v1/auth/register", {
                firstname: register.firstname,
                lastname: register.lastname,
                email: register.email,
                password: register.password,
            }).then(res => {
                const {data} = res;
                if (data.access_token && data.refresh_token) {
                    localStorage.setItem('access_token', data.access_token);
                    localStorage.setItem('refresh_token', data.refresh_token);
                    // history.push("/auth");
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
            <h2>Register user:</h2>
            <form onSubmit={submitCheckin}>
                <p>Firstname: <input
                    type="text"
                    id="firstname"
                    name="firstname"
                    value={register.firstname}
                    onChange={changeInputRegister}/>
                </p>
                <p>Lastname: <input
                    type="text"
                    id="lastname"
                    name="lastname"
                    value={register.lastname}
                    onChange={changeInputRegister}/>
                </p>
                <p>Email: <input
                    type="email"
                    id="email"
                    name="email"
                    value={register.email}
                    onChange={changeInputRegister}
                /></p>
                <p>Password: <input
                    type="password"
                    id="password"
                    name="password"
                    value={register.password}
                    onChange={changeInputRegister}
                /></p>
                <p>Repeat password: <input
                    type="password"
                    id="password2"
                    name="password2"
                    value={register.password2}
                    onChange={changeInputRegister}
                /></p>
                <input type="submit"/>
            </form>
        </div>
    )
}