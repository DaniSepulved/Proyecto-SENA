import React, { createContext, useContext, useState, useEffect } from 'react';

const AuthContext = createContext(null);
export const AuthProvider = ({ children }) => {
    const [isAuthenticated, setIsAuthenticated] = useState(() => {
        return !!localStorage.getItem('token');
    });
    const [userRole, setUserRole] = useState(() => {
        return localStorage.getItem('rol') || null;
    });

    useEffect(() => {
        const handleStorageChange = () => {
            setIsAuthenticated(!!localStorage.getItem('token'));
            setUserRole(localStorage.getItem('rol') || null);
        };
        window.addEventListener('storage', handleStorageChange);
        return () => window.removeEventListener('storage', handleStorageChange);
    }, []);

    const login = (token, email, role) => {
        localStorage.setItem('token', token);
        localStorage.setItem('usuario', email);
        localStorage.setItem('rol', role);
        setIsAuthenticated(true);
        setUserRole(role);
    };

    const logout = () => {
        localStorage.removeItem('token');
        localStorage.removeItem('usuario');
        localStorage.removeItem('rol');
        setIsAuthenticated(false);
        setUserRole(null);
    };

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

export const useAuth = () => {
    const context = useContext(AuthContext);
    if (!context) {
        throw new Error('useAuth must be used within an AuthProvider');
    }
    return context;
};