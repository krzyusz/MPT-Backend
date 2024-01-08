import React from 'react';
import { Link } from 'react-router-dom'; // Import the Link component from react-router-dom

const Sidebar = () => {
  const menuItems = ['Kalendarz zajęć', 'Ustawienia', 'Obecność', 'Opinie', 'Feed', 'Ankiety', 'Punkty'];

  return (
    <div className="sidebar">
      {menuItems.map((item, index) => (
        
        <div key={index} className="menu-item">
                <Link to="/main-content">Main Content</Link>
          {item}
        </div>
      ))}
    </div>
  );
};

export default Sidebar;