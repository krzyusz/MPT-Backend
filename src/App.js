// App.js
import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import AnkietaForm from './AnkietaForm';
import EditQuestions from './EditQuestions';
import './App.css';

function App() {
  return (
    <Router>
      <div className="App">
        <nav>
          <ul>
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="/edit-questions">Edit Questions</Link>
            </li>
          </ul>
        </nav>
        <Routes>
          <Route path="/edit-questions" element={<EditQuestions />} />
          <Route path="/" element={<AnkietaForm />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
