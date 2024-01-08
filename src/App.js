import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import AnkietaForm from './AnkietaForm';
import EditQuestions from './EditQuestions';
import MainContent from './MainContent'; // Import MainContent
import Sidebar from './Sidebar'; // Import Sidebar
import './App.css';

function App() {
  return (
    <Router>
      <div className="App">
        <Sidebar /> {/* This is the sidebar component */}
        <div className="content">
          <Routes>
            <Route path="/main-content" element={<MainContent />} /> {/* New route for MainContent */}
            <Route path="/edit-questions" element={<EditQuestions />} />
            <Route path="/" element={<AnkietaForm />} /> {/* Keep AnkietaForm at the home route */}
          </Routes>
        </div>
      </div>
    </Router>
  );
}

export default App;
