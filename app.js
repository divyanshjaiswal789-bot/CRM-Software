import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import Sidebar from './components/Sidebar';
import Dashboard from './pages/Dashboard';
import Customers from './pages/Customers';
import Login from './pages/Login';
import { useAuth } from './context/AuthContext';

function App() {
    const { user } = useAuth();

    return (
        <BrowserRouter>
            <div className="flex">
                {user && <Sidebar />}
                <div className="flex-1">
                    <Routes>
                        <Route path="/login" element={!user ? <Login /> : <Navigate to="/" />} />
                        <Route path="/" element={user ? <Dashboard /> : <Navigate to="/login" />} />
                        <Route path="/customers" element={user ? <Customers /> : <Navigate to="/login" />} />
                        {/* Add Lead, Task, and Sales routes similarly */}
                    </Routes>
                </div>
            </div>
        </BrowserRouter>
    );
}