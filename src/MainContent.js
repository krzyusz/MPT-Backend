import React from 'react';
import pandaImage from './path_to_panda_image.jpg'; // make sure to add your image in the src folder

const MainContent = () => {
  return (
    <div className="main-content" style={{ backgroundImage: `url(${pandaImage})` }}>
    </div>
  );
};

export default MainContent;
