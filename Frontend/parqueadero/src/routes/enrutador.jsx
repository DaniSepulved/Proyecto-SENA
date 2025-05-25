import RutaProtegida from '../components/RutaProtegida'
import Home from '../Home'
import Login from '../pages/Login'
import Cuenta from '../pages/Cuenta'
import ReservasEspacio from '../pages/ReservasEspacio'


export let enrutador = [
    {
        path: '/',
        element: <Login />
    },
    {
        path: '/home',
        element: <RutaProtegida proteger={<Home />} />,
        children:[
            {
                path: "/cuenta",
                element: <Cuenta/>
            },
            {
                path: "/reservasespacio",
                element: <ReservasEspacio/>
            },
            {  
                path: "/pagos",
                element: <Pagos/>
            }
        ]
    }
]