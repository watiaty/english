import './App.css';
import React, { Component } from 'react';
import Register from './components/LoginPage';

class App extends Component {
  state = {
    clients: []
  };

  async componentDidMount() {
    const response = await fetch('api/v1/words');
    const body = await response.json();
    this.setState({clients: body});
  }

  render() {
    const {clients} = this.state;
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
            <Register />
          </header>
        </div>
    );
  }
}

export default App;