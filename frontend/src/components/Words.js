import * as React from 'react';
import Button from '@mui/material/Button';
import ButtonGroup from '@mui/material/ButtonGroup';
import {DataGrid, GridColDef, GridValueGetterParams} from '@mui/x-data-grid';
import {useEffect, useState} from "react";

const columns: GridColDef[] = [
    {field: 'id', headerName: 'ID', width: 70},
    {field: 'word', headerName: 'Word', width: 130},
    {field: 'definition', headerName: 'Definition', width: 130},
    {
        field: 'partOfSpeech',
        headerName: 'Part of Speech',
        type: 'number',
        width: 180,
    },
    {
        field: 'level',
        headerName: 'Level',
        description: 'This column has a value getter and is not sortable.',
        sortable: false,
        width: 160,
    },
];

export default function Words() {
    const [words, setWords] = useState([]);
    const token = localStorage.getItem('access_token');

    const getLearningWords = async () => {
        try {
            const response = await fetch('api/v1/wordlist/learning', {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            });
            const body = await response.json();
            setWords(body);
        } catch (error) {
            console.error('Failed to fetch clients:', error);
        }
    };

    const getLearnedWords = async () => {
        try {
            const response = await fetch('api/v1/wordlist/learned', {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            });
            const body = await response.json();
            setWords(body);
        } catch (error) {
            console.error('Failed to fetch clients:', error);
        }
    };

    const getAllWords = async () => {
        try {
            const response = await fetch('api/v1/wordlist/all', {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            });
            const body = await response.json();
            setWords(body);
        } catch (error) {
            console.error('Failed to fetch words:', error);
        }
    }

    return (
        <div>
            <ButtonGroup variant="contained" aria-label="outlined primary button group">
                <Button onClick={getLearningWords}>Learning</Button>
                <Button onClick={getLearnedWords}>Learned</Button>
                <Button onClick={getAllWords}>All</Button>
            </ButtonGroup>
            <div style={{height: 400, width: '100%'}}>
                <DataGrid
                    rows={words}
                    columns={columns}
                    pageSize={5}
                    rowsPerPageOptions={[5]}
                    checkboxSelection
                />
            </div>
        </div>
    );
}
