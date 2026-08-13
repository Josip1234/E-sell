<?php

namespace Database\Seeders;

use App\Models\User;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\Hash;
use Faker\Factory as Faker;

class DatabaseSeeder extends Seeder
{
    use WithoutModelEvents;

    /**
     * Seed the application's database.
     */
    public function run(): void
    {
        User::factory(10000)->create();
        $faker=Faker::create();
       /* User::factory(10)->create([
            "firstName" => $faker->firstName,
            "lastName"=>$faker->lastName,
            "password"=> Hash::make('tester1234'),
            "username"=>$faker->userName,
            "userType"=>$faker->randomKey([0,1]),
            "profilePicture"=>$faker->imageUrl
        ]);
        */
    }
}
