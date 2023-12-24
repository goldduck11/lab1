const express = require('express');
const bodyParser = require('body-parser');

const app = express();
const port = 8080;

// Используйте middleware bodyParser для обработки данных в теле запроса
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

// Обработчик POST-запроса
app.post('/example', (req, res) => {
  const requestData = req.body; // Данные из тела POST-запроса
  console.log('Received data:', requestData);
  res.json({ success: true, data: requestData });
});

// Запуск сервера
app.listen(port, () => {
  console.log(`Сервер запущен на порту ${port}`);
});