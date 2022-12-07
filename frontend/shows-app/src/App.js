import './App.css';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Home from './Components/home/Home';
import SignIn from './Components/Login/SignIn';
import SignUp from './Components/Login/SignUp';

function App() {
  return (
    <>
      <div className="App">
        <Router>
          <Routes>
            <Route path="/" element={<Home/>} />
            <Route path="/sign-in" element={<SignIn/>} />
            <Route path="/sign-up" element={<SignUp/>} />
          </Routes>
        </Router>
      </div>
    </>
  );
}

export default App;
