import express from 'express';
import userRoutes from './usersRoutes.js';
import taskRoutes from './tasksRoutes.js';
import categoryRoutes from './categoriesRoutes.js';

const routes = express.Router();

routes.use('/users', userRoutes);
routes.use('/tasks', taskRoutes);
routes.use('/categories', categoryRoutes);

export default routes;
