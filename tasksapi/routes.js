import express from 'express';
import users from './src/controllers/usersController.js';
import tasks from './src/controllers/tasksController.js';

const routes = express.Router();

routes.get('/users',users.findAll);
routes.get('/users/:id',users.findUser);
routes.put('/users/:id',users.updateUser);
routes.delete('/users/:id',users.deleteUser);
routes.post('/users', users.addUser);

routes.get('/tasks', tasks.findAll);
routes.get('/tasks',tasks.findTarefa);
routes.put('/tasks',tasks.updateTarefa);
routes.delete('/tasks/:id',tasks.deleteTarefa);
routes.post('/tasks',tasks.addTarefa);



export { routes as default };