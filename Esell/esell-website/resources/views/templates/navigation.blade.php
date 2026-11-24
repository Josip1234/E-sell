  <header class="site-header">
    <div class="container header-inner">
        <nav class="nav">
            @if(request()->routeIs('login'))
     <a href="{{ route('esell.home') }}" class="nav-link">Homepage</a>
    @else
     <a href="{{ route('login') }}" class="nav-link">Login</a>
@endif


</nav>
     </div>

  </header>
