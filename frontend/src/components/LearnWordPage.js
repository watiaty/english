import React, {useState, useEffect} from "react";
import {Button, ButtonGroup, Card, CardActions, CardContent} from "@mui/material";
import LinearProgress, {LinearProgressProps} from '@mui/material/LinearProgress';
import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";

export default function WordLearningComponent() {
    const [wordList, setWordList] = useState([]);
    const [currentWord, setCurrentWord] = useState(null);
    const [progress, setProgress] = React.useState(0);

    useEffect(() => {
        const token = localStorage.getItem('access_token');
        fetch("http://localhost:8080/api/v1/words/new-words", {
            headers: {
                Authorization: `Bearer ${token}`,
            },
        })
            .then((response) => response.json())
            .then((data) => {
                setWordList(data);
                setCurrentWord(data[0]); // Устанавливаем первое слово как текущее
            })
            .catch((error) => console.error("Ошибка при загрузке слов: ", error));
    }, []);

    const handleLearnClick = () => {
        const token = localStorage.getItem('access_token');
        if (currentWord) {
            const request = {
                wordId: currentWord.id,
            };
            fetch("http://localhost:8080/api/v1/wordlist/learning", {
                method: "POST",
                headers: {
                    Authorization: `Bearer ${token}`,
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(request),
            })
                .then(() => {
                    // Удаляем текущее слово из списка слов
                    setWordList((prevWordList) => prevWordList.filter((word) => word.id !== currentWord.id));
                    setCurrentWord(wordList[1]); // Устанавливаем следующее слово как текущее
                    setProgress(progress + 5);
                })
                .catch((error) => console.error("Ошибка при добавлении слова в список изучаемых: ", error));
        }
    };

    // Обработчик нажатия на кнопку "Уже знаю"
    const handleAlreadyKnowClick = () => {
        const token = localStorage.getItem('access_token');
        if (currentWord) {
            const request = {
                wordId: currentWord.id,
            };
            fetch("http://localhost:8080/api/v1/wordlist/not-learning", {
                method: "POST",
                headers: {
                    Authorization: `Bearer ${token}`,
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(request),
            })
                .then(() => {
                    // Удаляем текущее слово из списка слов
                    setWordList((prevWordList) => prevWordList.filter((word) => word.id !== currentWord.id));
                    setCurrentWord(wordList[1]);
                    setProgress(progress + 5);
                    // Устанавливаем следующее слово как текущее
                })
                .catch((error) => console.error("Ошибка при добавлении слова в список изученных: ", error));
        }
    };

    function LinearProgressWithLabel(props: LinearProgressProps & { value: number }) {
        return (
            <Box sx={{display: 'flex', alignItems: 'center'}}>
                <Box sx={{width: '100%', mr: 1}}>
                    <LinearProgress variant="determinate" {...props} />
                </Box>
                <Box sx={{minWidth: 35}}>
                    <Typography variant="body2" color="text.secondary">{`${Math.round(
                        props.value,
                    )}%`}</Typography>
                </Box>
            </Box>
        );
    }


    return (
        <div>
            {currentWord ? (
                <div align="center">
                    <Box sx={{maxWidth: 275}}>
                        <Card variant="outlined">
                            <React.Fragment>
                                <CardContent>
                                    <Typography variant="h2" component="div" align="center">
                                        {currentWord.word}
                                    </Typography>
                                    <Typography sx={{mb: 1.5}} color="text.secondary">
                                        adjective
                                    </Typography>
                                </CardContent>
                                <CardActions>
                                    <Button size="small">Learn More</Button>
                                </CardActions>
                            </React.Fragment>
                        </Card>
                    </Box>

                    <ButtonGroup
                        disableElevation
                        variant="contained"
                        aria-label="Disabled elevation buttons"
                    >
                        <Button onClick={handleLearnClick}>Учить</Button>
                        <Button onClick={handleAlreadyKnowClick}>Уже знаю</Button>
                    </ButtonGroup>
                    <LinearProgressWithLabel value={progress}/>
                </div>
            ) : (
                <p>Слова закончились</p>
            )}
        </div>
    );
};