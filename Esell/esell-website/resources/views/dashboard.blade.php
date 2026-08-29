<x-app-layout>
    <x-slot name="header">
        <h2 class="font-semibold text-xl text-gray-800 leading-tight">
            {{ __('Your adverts') }}
        </h2>
    </x-slot>
    <div class="pb-[20%] bg-white shadow">
                    <div class="flex items-center justify-center w-full transition-opacity opacity-100 duration-750 lg:grow starting:opacity-0">

               <div class="max-w-sm bg-white border border-gray-200 rounded-2xl shadow-md overflow-hidden mb-2">
                    @php
                       //algorithm
                       $image="";
                       $imgToGet="uploads/index7.jpg";
                       $images = File::allFiles('uploads');
                       foreach ($images as $value) {
                         $strReplace=str_replace("\\","/",$value);

                         if($imgToGet===$strReplace){
                             $image=$strReplace;
                            break;
                         }
                       }
                    @endphp
                    <!-- Card Image -->
                    <img class="w-full h-48 object-cover" src="{{ $image }}" alt="Cover">
                    <!-- Card Body -->
                    <div class="p-5">
                        <h5 class="mb-2 text-xl font-bold tracking-tight text-gray-900">
                            Card title
                        </h5>
                        <p class="mb-4 text-gray-600">Here are the biggest enterprise technology acquisitions of 2021.</p>
                        <a href="#" class="inline-flex items-center px-4 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700">
                            Read more
                        </a>
                    </div>
                </div>
                 <div class="max-w-sm bg-white border border-gray-200 rounded-2xl shadow-md overflow-hidden mb-2">
                    @php
                       //algorithm
                       $image="";
                       $imgToGet="uploads/index7.jpg";
                       $images = File::allFiles('uploads');
                       foreach ($images as $value) {
                         $strReplace=str_replace("\\","/",$value);

                         if($imgToGet===$strReplace){
                             $image=$strReplace;
                            break;
                         }
                       }
                    @endphp
                    <!-- Card Image -->
                    <img class="w-full h-48 object-cover" src="{{ $image }}" alt="Cover">
                    <!-- Card Body -->
                    <div class="p-5">
                        <h5 class="mb-2 text-xl font-bold tracking-tight text-gray-900">
                            Card title
                        </h5>
                        <p class="mb-4 text-gray-600">Here are the biggest enterprise technology acquisitions of 2021.</p>
                        <a href="#" class="inline-flex items-center px-4 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700">
                            Read more
                        </a>
                    </div>
                </div>
                 <div class="max-w-sm bg-white border border-gray-200 rounded-2xl shadow-md overflow-hidden mb-2">
                    @php
                       //algorithm
                       $image="";
                       $imgToGet="uploads/index8.jpg";
                       $images = File::allFiles('uploads');
                       foreach ($images as $value) {
                         $strReplace=str_replace("\\","/",$value);

                         if($imgToGet===$strReplace){
                             $image=$strReplace;
                            break;
                         }
                       }
                    @endphp
                    <!-- Card Image -->
                    <img class="w-full h-48 object-cover" src="{{ $image }}" alt="Cover">
                    <!-- Card Body -->
                    <div class="p-5">
                        <h5 class="mb-2 text-xl font-bold tracking-tight text-gray-900">
                            Card title
                        </h5>
                        <p class="mb-4 text-gray-600">Here are the biggest enterprise technology acquisitions of 2021.</p>
                        <a href="#" class="inline-flex items-center px-4 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700">
                            Read more
                        </a>
                    </div>
                </div>
                </div>
    </div>
</x-app-layout>
