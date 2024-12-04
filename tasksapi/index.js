import { Sequelize } from 'sequelize';
import config from '../config/config.json';
import routes from "./src/routers/routes.js";

const sequelize = new Sequelize(
    config.database,
    config.username,
    config.password,
    config
  );
  
  const db = { sequelize, Sequelize };
  
/* GET home page. */
routes.get("/", function (req, res, next) {
    res.status(200).send("Ok").end();
});

export { routes as default };