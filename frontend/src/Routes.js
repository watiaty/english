import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import TestPage from './components/TestPage';
import LoginPage from './components/LoginPage';
import RegisterPage from './components/RegisterPage';
import LogoutPage from "./components/LogoutPage";

const Routes = () => {
    return (
        <Router>
            <Switch>
                <Route exact path="/" component={TestPage} />
                <Route exact path="/login" component={LoginPage} />
                <Route exact path="/register" component={RegisterPage} />
                <Route exact path="/logout" component={LogoutPage}/>
            </Switch>
        </Router>
    );
};

export default Routes;