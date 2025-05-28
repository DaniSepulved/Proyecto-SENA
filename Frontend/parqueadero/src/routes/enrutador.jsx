import RutaProtegida from '../components/RutaProtegida'
import Home from '../Home' // Este es tu componente de layout principal para el área protegida
import Login from '../pages/Login'
import Cuenta from '../pages/Cuenta'
import ReservasEspacio from '../pages/ReservasEspacio'
import Pagos from '../pages/Pagos'

export let enrutador = [
  {
    path: '/',
    element: <Login />
  },
  {
    element: <RutaProtegida />,
    children: [
      {
        path: '/home',
        element: <Home />,
        children: [
          {
            index: true, // Esto se renderiza cuando la URL es EXACTAMENTE /home
            element: <div>Bienvenido al Panel de Control!</div> // O un componente de dashboard más elaborado
          },
          {
            path: 'Cuenta', // Ruta completa: /home/Cuenta
            element: <Cuenta />
          },
          {
            path: 'ReservasEspacio', // Ruta completa: /home/ReservasEspacio
            element: <ReservasEspacio />
          },
          {
            path: 'Pagos', // Ruta completa: /home/Pagos
            element: <Pagos />
          },
        ]
      }
      // Si tuvieras otras rutas protegidas que no usan el layout de Home, irían aquí.
      // Por ejemplo, una ruta protegida con un layout diferente:
      // {
      //   path: '/admin',
      //   element: <AdminLayout />,
      //   children: [
      //     { path: 'users', element: <AdminUsers /> }
      //   ]
      // }
    ]
  }
];