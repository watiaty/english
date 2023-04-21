import React, {useState, useEffect} from 'react';
import axios from 'axios';

export default function Test()  {
    const [data, setData] = useState(null);

    useEffect(() => {
        const token = localStorage.getItem('access_token');
        axios.get('http://localhost:8080/api/v1/demo-controller', {
            headers: {
                'Authorization': `Bearer ${token}`
            }
        })
            .then(response => {
                setData(response.data);
            })
            .catch(error => {
                console.log(error);
            });
    }, []);

    return (
        <div>
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
