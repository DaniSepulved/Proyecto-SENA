import React, { createContext, useContext, useState, useEffect } from 'react';

// 1. Crea el contexto
const AuthContext = createContext(null);

// 2. Crea el proveedor del contexto
export const AuthProvider = ({ children }) => {
    // Estado local para la autenticación y el rol
    const [isAuthenticated, setIsAuthenticated] = useState(() => {
        // Inicializa el estado leyendo de localStorage al cargar la app
        return !!localStorage.getItem('token');
    });
    const [userRole, setUserRole] = useState(() => {
        return localStorage.getItem('rol') || null;
    });

    // Este efecto escucha cambios en localStorage (ej. cuando se cierra otra pestaña)
    useEffect(() => {
        const handleStorageChange = () => {
            setIsAuthenticated(!!localStorage.getItem('token'));
            setUserRole(localStorage.getItem('rol') || null);
        };
        window.addEventListener('storage', handleStorageChange);
        return () => window.removeEventListener('storage', handleStorageChange);
    }, []);

    // Función para iniciar sesión (actualiza estado y localStorage)
    const login = (token, email, role) => {
        localStorage.setItem('token', token);
        localStorage.setItem('usuario', email);
        localStorage.setItem('rol', role);
        setIsAuthenticated(true);
        setUserRole(role);
    };

    // Función para cerrar sesión (actualiza estado y localStorage)
    const logout = () => {
        localStorage.removeItem('token');
        localStorage.removeItem('usuario');
        localStorage.removeItem('rol');
        setIsAuthenticated(false);
        setUserRole(null);
    };

    // El valor que se provee a los componentes hijos
    const contextValue = {
        isAuthenticated,
        userRole,
        login,
        logout
    };

    return (
        <AuthContext.Provider value={contextValue}>
            {children}
        </AuthContext.Provider>
    );
};

// 3. Hook personalizado para consumir el contexto fácilmente
export const useAuth = () => { // <--- ¡Asegúrate de que tenga 'export' y 'const'!
    const context = useContext(AuthContext);
    if (!context) {
        throw new Error('useAuth must be used within an AuthProvider');
    }
    return context;
};