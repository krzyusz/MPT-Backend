// EditQuestions.js
import React, { useState } from 'react';
import './EditQuestions.css';

const EditQuestions = () => {
  // Replace this with the actual method to fetch questions from your backend or state management
  const initialQuestions = [
    "Czy zajęcia rozpoczęły się i zakończyły zgodnie z planem zajęć?",
    "Czy na zajęciach odbył się test wejściowy?",
    // ... other initial questions
  ];

  const [questions, setQuestions] = useState(initialQuestions);
  const [newQuestion, setNewQuestion] = useState('');

  const handleQuestionChange = (index, newQuestion) => {
    const updatedQuestions = questions.map((q, idx) => idx === index ? newQuestion : q);
    setQuestions(updatedQuestions);
  };

  const handleAddQuestion = () => {
    setQuestions([...questions, newQuestion]);
    setNewQuestion('');
  };

  const handleDeleteQuestion = (index) => {
    const updatedQuestions = questions.filter((_, idx) => idx !== index);
    setQuestions(updatedQuestions);
  };

  return (
    <div className="edit-questions">
      <h2>Edit Questions</h2>
      {questions.map((question, index) => (
        <div key={index} className="edit-question">
          <input
            type="text"
            value={question}
            onChange={(e) => handleQuestionChange(index, e.target.value)}
          />
          <button onClick={() => handleDeleteQuestion(index)}>Delete</button>
        </div>
      ))}
      <div className="add-question">
        <input
          type="text"
          value={newQuestion}
          onChange={(e) => setNewQuestion(e.target.value)}
        />
        <button onClick={handleAddQuestion}>Add New Question</button>
      </div>
    </div>
  );
};

export default EditQuestions;
