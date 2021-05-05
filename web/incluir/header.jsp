    <header class="main-header">
        <div class="container container--flex">
                <div id="logo-container">
                    <img src="imagen/logo.png" height="150px" width="150px">
                </div>
            <div class="main-header__container">
                <h1 class="main-header__title">Marie Party Decorationes</h1>
                <span class="icon-menu" id="btn-menu"><i class="fas fa-bars"></i> Menu</span>
                <nav class="main-nav" id="main-nav">
                    <ul class="menu" id="menu">
                        <li class="menu__item"><a href="index.jsp" class="menu__link">Inicio</a></li>
                        <li class="menu__item container-submenu">
                            <a href="#" class="menu__link submenu-btn">Productos <i class="fas fa-chevron-down"></i></a>
                            <ul class="submenu">
                                <li class="menu__item"><a href="RecuperarProductos" class="menu__link">Todos los productos</a></li>
                                <li class="menu__item"><a href="RecuperarProductos?familia=1" class="menu__link">Tartas</a></li>
                                <li class="menu__item"><a href="RecuperarProductos?familia=2" class="menu__link">Regalos</a></li>
                                <li class="menu__item"><a href="" class="menu__link">Candy Bar</a></li>
                                <li class="menu__item"><a href="" class="menu__link">Articulos</a></li>
                            </ul>
                        </li>
                        <li class="menu__item"><a href="eventos.jsp" class="menu__link">Evento</a></li>
                        <li class="menu__item"><a href="#" class="menu__link">Reposteria</a></li>
                        <li class="menu__item"><a href="#" class="menu__link">Sobre mi</a></li>
                        <li class="menu__item"><a href="FormularioProducto" class="menu__link">Contacto</a></li>
                        
                    </ul>
                </nav>
            </div>
            <div class="main-header__container">
                <a href="IniciarSesion.jsp" class="main-header__link"><i  class="fas fa-user"></i> Iniciar Sesion</a>
                <a href="" class="main-header__btn">My cart <i class="fas fa-shopping-cart"></i>(0)</a>
                <input type="search" class="main-header__input" placeholder="Buscar productos">
                <i  class="fas fa-search"></i>

            </div>
        </div>
    </header>