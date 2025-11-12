import RutaProtegida from '../components/RutaProtegida'
import Home from '../Home' // Este es tu componente de layout principal para el área protegida
import Login from '../pages/Login'
import Cuenta from '../pages/Cuenta'
import ReservasEspacio from '../pages/ReservasEspacio'
import Pagos from '../pages/Pagos'
import Contacto from '../pages/Contacto'

export let enrutador = [
  {
    path: '/',
    element: <Login />
  },
  {
    element: <RutaProtegida />,
    children: [
      { path: '/home', element: <Home /> },
      { path: '/cuenta', element: <Cuenta /> },
      { path: '/reservas', element: <ReservasEspacio /> },
    ]
  },
  { path: '/pagos', 
    element: <Pagos /> 
  },
  {
    path: '/contacto',
    element: <Contacto /> // página independiente
  }
];