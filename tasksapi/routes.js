import express from 'express';
import userRoutes from './src/routers/usersRoutes.js';
import taskRoutes from './src/routers/tasksRoutes.js';
import categoryRoutes from './src/routers/categoriesRoutes.js';

const routes = express.Router();

routes.use('/users', userRoutes);
routes.use('/tasks', taskRoutes);
routes.use('/categories', categoryRoutes);

export default routes;
