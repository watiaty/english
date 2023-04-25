import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import TestPage from './components/TestPage';
import LogoutPage from "./components/LogoutPage";
import LearnWordPage from "./components/LearnWordPage"
import SignIn from "./components/SignIn"
import SignUp from "./components/SignUp"
import Words from "./components/Words"

const Routes = () => {
    return (
        <Router>
            <Switch>
                <Route exact path="/" component={TestPage} />
                <Route exact path="/logout" component={LogoutPage}/>
                <Route exact path="/new-words" component={LearnWordPage}/>
                <Route exact path="/sign-in" component={SignIn}/>
                <Route exact path="/sign-up" component={SignUp}/>
                <Route exact path="/my-words" component={Words}/>
            </Switch>
        </Router>
    );
};

export default Routes;