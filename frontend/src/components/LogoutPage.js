import axios from 'axios';

const logout = async () => {
    try {
        const response = await axios.post('http://localhost:8080/api/v1/auth/logout');
        // Обработка успешного ответа
    } catch (error) {
        // Обработка ошибки
    }
};

export default logout;
