import express from 'express';
import routes from './routes.js';
import db from './models';
import dotenv from 'dotenv';

dotenv.config();
const app = express();

app.use(express.json());
app.use(routes);

db.sync( () => 
    console.log(`Banco de dados conectado: ${process.env.DB_NAME}`)
);

app.listen(3000, () => 
    console.log('Servidor iniciado na porta 3000')
);

db.sequelize.sync({ force: true }).then(() => {
    console.log("Banco de dados sincronizado.");
  });

  db.sequelize
  .authenticate()
  .then(() => console.log('Conexão sucedida!'))
  .catch((err) => console.error('Erro ao conectar:', err));
