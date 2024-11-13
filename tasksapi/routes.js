import express from 'express';
import users from './src/controllers/users.js';

const routes = express.Router();

routes.get('/users',users.findAll);
routes.get('/users/:id',users.findClient);
routes.put('/users/:id',users.updateClient);
routes.delete('/users/:id',users.deleteClient);
routes.post('/users', users.addClient);

export { routes as default };