import React from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import App from './App';
import Login from './components/LoginPage';
import Register from './components/RegisterPage';

const Routes = () => (
    <Router>
        <Routes>
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route path="/" element={<App />} />
        </Routes>
    </Router>
);

export default Routes;